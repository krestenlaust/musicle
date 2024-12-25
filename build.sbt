import org.scalajs.linker.interface.{ ModuleKind, ModuleSplitStyle }

val scala3Version = "3.5.2"

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)        // Enable the Scala.js plugin in this project
  .enablePlugins(ScalaJSBundlerPlugin) // Enable ScalaJSBundlerPlugin for npm dependencies
  .enablePlugins(ScalablyTypedConverterExternalNpmPlugin)
  .settings(
    name         := "Musicle",
    version      := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),

    // Tell Scala.js that this is an application with a main method
    scalaJSUseMainModuleInitializer := true,

    /* Configure Scala.js to emit modules in the optimal way to
     * connect to Vite's incremental reload.
     * - emit ECMAScript modules
     * - emit as many small modules as possible for classes in the "musicle" package
     * - emit as few (large) modules as possible for all other classes
     *   (in particular, for the standard library)
     */
    scalaJSLinkerConfig ~= {
      _.withOptimizer(false)
        .withModuleKind(ModuleKind.CommonJSModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("musicle")))
    },
    libraryDependencies ++= Seq(
      "com.raquo"         %%% "laminar"              % "17.0.0",
      "io.github.cquiroz" %%% "scala-java-time"      % "2.5.0",
      "io.github.cquiroz" %%% "scala-java-time-tzdb" % "2.5.0",
    ),

    // Tell ScalablyTyped that we manage `npm install` ourselves
    externalNpm := baseDirectory.value,
    Compile / npmDependencies ++= Seq(
    ),
  )
