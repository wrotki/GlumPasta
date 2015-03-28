name := "Lift 2.6 starter template"

version := "0.0.4"

organization := "net.liftweb"

scalaVersion := "2.11.2"

//tomcat()
jetty()

lazy val root = (project in file(".")).enablePlugins(SbtWeb)//.settings(webappSrc in webapp <<= WebKeys.assets in Assets)

unmanagedResourceDirectories in Test <+= (baseDirectory) { _ / "src/main/webapp" }

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= {
  val liftVersion = "2.6"
  Seq(
    "net.liftweb"       %% "lift-webkit"        % liftVersion        % "compile",
    "net.liftweb"       %% "lift-mapper"        % liftVersion        % "compile",
    "net.liftmodules"   %% "lift-jquery-module_2.6" % "2.8",
    "org.eclipse.jetty" % "jetty-webapp" % "9.1.0.v20131115" % "container,test",
    "org.eclipse.jetty" % "jetty-plus" % "9.1.0.v20131115" % "container,test",
    "javax.servlet" % "javax.servlet-api" % "3.1.0" % "container,test",
    "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container,test" artifacts Artifact("javax.servlet", "jar", "jar"),
    "ch.qos.logback"    % "logback-classic"     % "1.0.6",
    "org.specs2"        %% "specs2"             % "2.3.12"           % "test",
    "com.h2database"    % "h2"                  % "1.3.167",
    //"org.webjars" %% "webjars-play" % "2.3.0-2",
    "org.webjars" % "bootstrap" % "3.1.1-2",
    "org.webjars" % "webjars-locator" % "0.19",
    "org.webjars" % "requirejs" % "2.1.16"
  )
}

includeFilter in (Assets, LessKeys.less) :=  "base.less"

(compile in Compile) <<= (compile in Compile) dependsOn (WebKeys.assets)


// http://stackoverflow.com/questions/29154360/how-can-sbt-web-output-be-used-with-xsbt-web-plugin-via-a-sbt-project-dependency