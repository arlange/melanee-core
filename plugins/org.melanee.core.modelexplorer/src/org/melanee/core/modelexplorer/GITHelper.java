package org.melanee.core.modelexplorer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.errors.CorruptObjectException;
import org.eclipse.jgit.errors.IncorrectObjectTypeException;
import org.eclipse.jgit.errors.MissingObjectException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevTree;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;
import org.eclipse.jgit.treewalk.TreeWalk;

public class GITHelper {

  Repository repository = null;
  Ref headRef = null;
  RevTree headTree = null;

  String cacheLocation = null;

  public GITHelper(String repoURL) {
    try {
      cacheLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().toString()
          + "/.metadata/.plugins/" + Activator.PLUGIN_ID + "/temp/git";

      // Delete the cache if it exists
      File cache = new File(cacheLocation);
      if (cache.exists())
        deleteDir(cache);

      FileRepositoryBuilder builder = new FileRepositoryBuilder();
      Git result = Git.cloneRepository().setURI(repoURL).setDirectory(new File(cacheLocation))
          .call();
      this.repository = result.getRepository();// builder.setGitDir(new File(cacheLocation +
                                               // "/.git")).readEnvironment().findGitDir().build();
      this.headRef = repository.getRef("HEAD");
      this.headTree = getHeadTree();

    } catch (IOException e) {
      e.printStackTrace();
    } catch (InvalidRemoteException e) {
      e.printStackTrace();
    } catch (TransportException e) {
      e.printStackTrace();
    } catch (GitAPIException e) {
      e.printStackTrace();
    }

  }

  public static boolean deleteDir(File dir) {
    if (dir.isDirectory()) {
      String[] children = dir.list();
      for (int i = 0; i < children.length; i++) {
        boolean success = deleteDir(new File(dir, children[i]));
        if (!success) {
          return false;
        }
      }
    }
    return dir.delete();
  }

  private RevTree getHeadTree()
      throws MissingObjectException, IncorrectObjectTypeException, IOException {
    RevWalk walk = new RevWalk(repository);
    RevCommit headCommit = walk.parseCommit(headRef.getObjectId());
    return headCommit.getTree();
  }

  public List<String> getFileList() throws MissingObjectException, IncorrectObjectTypeException,
      CorruptObjectException, IOException {
    List<String> result = new ArrayList<String>();

    TreeWalk treeWalk = new TreeWalk(repository);
    treeWalk.addTree(headTree);
    treeWalk.setRecursive(true);

    while (treeWalk.next())
      result.add(treeWalk.getPathString());

    treeWalk.reset();

    return result;
  }

  public InputStream getInputStreamForFile(String file) throws MissingObjectException,
      IncorrectObjectTypeException, CorruptObjectException, IOException {
    InputStream result = null;

    TreeWalk treeWalk = TreeWalk.forPath(repository, file, headTree);
    result = repository.open(treeWalk.getObjectId(0)).openStream();

    return result;
  }

  /**
   * Use this method to prevent file handle leaks
   */
  public void closeRepository() {
    // Close the repository to release all file handles
    repository.close();

    // Delete the cache if it exists
    File cache = new File(cacheLocation);
    if (cache.exists())
      deleteDir(cache);
  }
}
