package me.vincentzz.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}

/**
  * created by Vincent Zhang 16-6-19
  */
@SpringBootApplication
@EnableAutoConfiguration
class HelloWorld

object HelloWorld {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[HelloWorld], args: _*)
  }
}
