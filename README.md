melanee-core
============

The core components of Melanee these include

- The Multi-level Modeling meta-model named Pan-level Model (PLM)
- A GMF Editor supporting the multi-level modeling concrete syntax named Level-agnostic Modeling Language (LML)
- The workbench offering extension points
- An extensible editor allowing to define domain-specific languages in a tree-based editor
- A simple autolayout service for connections and generalizations
- An emendation service which supports changing a multi-level model
- A designation service for customizing the designation part of the Level-agnostic Modeling Language

## Builbing Melanee
If you want to build Melanee for your local repository then do the following
```
cd melanee-core
mvn clean install
```
If you want to build Melanee as an Eclipse product then do this
```
cd melanee-core/features/org.melanee.core.product
mvn clean install -Ppackage
```
This will build packages (zip files) for the major operating systems.
