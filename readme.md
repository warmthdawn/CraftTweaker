# Description

**This is a fork of [crafttweaker](https://github.com/CraftTweaker/CraftTweaker/tree/1.12), adding support of some debug features.**

Used together with vscode plugin [Debugger for Zen](https://github.com/warmthdawn/debugger-for-zen)


# CraftTweaker

Welcome to the Crafttweaker source! Crafttweaker is the official continuation of Minetweaker 3 and plans on staying updated for the latest Minecraft versions.

## License and contributions

You are free to distribute the mod by itself and in modpacks as long as it is not being sold or redistributed on advertisement sponsored sites. You may create derivative works, but you may not redistribute it under an identical name.

Want to contribute? That's great! Contact me if you want to propose or discuss new features. Adding new mods is definitely welcome and doesn't need prior permission (just follow the existing structure, add it & make a pull request). Credit will be granted appropriately.

## Project structure and building

The CraftTweaker 2 source is setup as a multi-project Gradle project:

- ZenScript is the custom scripting engine
- CraftTweaker2-API is the shared API for all CraftTweaker versions
- CraftTweaker2-MCXYZ-Main are the main CraftTweaker implementations for Minecraft X.Y.Z
- CraftTweaker2-MCXYZ-Mod-XXX are the mod support projects. They are compiled and obfuscated independently and then assembled later

### Developing and running CraftTweaker from source

Configuration settings are stored in configuration.gradle.

In order to use the project, you have to execute the setupDecompWorkspaceAll. It will prepare all the subprojects for you. After that, you can simply run minecraft with the runClient task in CraftTweaker2-XYZ-Main project, which will run CraftTweaker (without mod support). Likewise, you can use the runClient task on any of its mod support library subprojects, which will run CraftTweaker with only the mod support for that specific mod.

The following global tasks are available:

- setupDecompWorkspaceAll: sets up all workspaces in all subprojects
- assembleAll: builds all versions of CraftTweaker

### Adding mod support

When starting a new mod support library, it is best to start from an existing one. For instance, copy the NEI support library, and remove the source files inside the src/java/main directory. Then you can work with it like any other support library. Make sure to update configuration.gradle to add the projects in there.

### Building a release

Use the assembleAll task to build all versions, or assembleMCxxx tasks to build a specific version. The files will be output in /build/libs .

## Customized builds

You may modify and redistribute your own customized version of CraftTweaker as long as you mark your own version of CraftTweaker as CUSTOMIZED (that is, put CUSTOMIZED in both the jar and mod name) and as long as you make the modified source code publicly available. Obviously, I cannot offer support for customized builds. Just be so kind to mention the original source and author (Stan) ;)
