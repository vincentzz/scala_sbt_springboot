import com.github.retronym.SbtOneJar._
import sbt.Keys._
import sbt._

object Build extends Build {
  override lazy val settings = super.settings :+ {
    shellPrompt := (s => Project.extract(s).currentProject.id + " > ")
  }

  // project config
  val projectName = "scala_sbt_springboot"
  val projectVersion = "1.0"

  // compiler config
  val scalacVersion = "2.11.8"
  val javacSourceVersion = "1.7"
  val javacTargetVersion = "1.7"

  //dependencies
  val verSpringBoot = "1.3.3.RELEASE"
  val verJacksonScalaModule = "2.7.4"
  val _springBootStarterWeb = "org.springframework.boot" % "spring-boot-starter-web" % verSpringBoot
  val _springBootStarterTest = "org.springframework.boot" % "spring-boot-starter-test" % verSpringBoot
  val _jacksonScalaModule = "com.fasterxml.jackson.module" %%  "jackson-module-scala" % verJacksonScalaModule
  val _springBootStarterVelocity = "org.springframework.boot" % "spring-boot-starter-velocity" % verSpringBoot


  lazy val root = Project(projectName, file("."))
    .settings(
      description := "Spring boot scala",
      version := projectVersion,

      //homepage := Some(new URL("https://github.com/vincentzz/scala_sbt_springboot")),
      //organization := "me.vincentzz",
      //organizationHomepage := Some(new URL("http://www.vincentzz.me")),
      startYear := Some(2016),
      scalaVersion := scalacVersion,
      scalacOptions ++= Seq(
        "-encoding", "utf8",
        "-unchecked",
        "-feature",
        "-deprecation"
      ),
      javacOptions ++= Seq(
        "-source", javacSourceVersion,
        "-target", javacTargetVersion,
        "-encoding", "utf8",
        "-Xlint:unchecked",
        "-Xlint:deprecation"
      ),
      offline := true,
      libraryDependencies ++= Seq(
        _springBootStarterWeb,
        _springBootStarterTest,
        _jacksonScalaModule,
        _springBootStarterVelocity),


      exportJars := true,
      mainClass in oneJar := Some("me.vincentzz.demo.HelloWorld"),
      Seq(oneJarSettings: _*),
      mappings in oneJar += (file("src/main/resources/web/*.html"),"./")
    )
}
