package me.vincentzz.demo.controller

import me.vincentzz.demo.model.{Animal, Human}
import me.vincentzz.demo.service.ScalaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestParam, _}
import org.springframework.web.servlet.ModelAndView

import scala.util.Random

/**
  * Created by Vincent Zhang on 16-6-19.
  */
@Controller
class ScalaController {
  @Autowired
  var scalaService: ScalaService = _

  /**
    * give me a seed i will return you a random long with this seed
    *
    * @param seed the seed
    * @return the random Long
    */
  @RequestMapping(value = Array("/random"), method = Array(RequestMethod.GET))
  @ResponseBody
  def randomLong(@RequestParam(required = false, defaultValue = "1") seed: Long): Long = {
    val random = new Random(seed)
    print("hello world")
    random.nextLong()
//    random.
  }

  @RequestMapping(value = Array("/reverse"))
  @ResponseBody
  def reverse(@RequestParam(value = "name", required = false, defaultValue = "zz") name: String) = {
    scalaService.reverse(name)
  }

  @RequestMapping(value = Array("/coll"), method =  Array(RequestMethod.GET) , produces = Array("application/json"))
  @ResponseBody
  def coll() = {
    val a = Map[String, String]("Hello" -> "world")
    a
  }

  @RequestMapping(value = Array("/human"), method =  Array(RequestMethod.GET) , produces = Array("application/json"))
  @ResponseBody
  def human = {
    new Human("zz", 27, true)
  }

  @RequestMapping(value = Array("/map"), method =  Array(RequestMethod.GET) , produces = Array("application/json"))
  @ResponseBody
  def map = {
    val a  = new Human ("zz", 27, true)
    a.age = 5;
    Map("abc" -> new Animal("abc", 3), "bcd" -> a)
  }

  //TODO not working now
  @RequestMapping(value = Array("/greeting") , method = Array(RequestMethod.GET))
  def greeting (@RequestParam(value = "name", required = false, defaultValue = "zz") name: String, model : Model) : String = {
    model.addAttribute("abc", name)

    //returning the view name, by default it will same as mapping url
    //in this case is "greeting"
    "greeting"
  }

  @RequestMapping(value = Array("/greeting2") , method = Array(RequestMethod.GET))
  def greeting2 (@RequestParam(value = "name", required = false, defaultValue = "zz") name: String) : ModelAndView = {
    val mav = new ModelAndView
    mav.setViewName("greeting")
    mav.addObject("abc", name)

    //returning the view name, by default it will same as mapping url
    //in this case is "greeting"
    mav
  }
}
