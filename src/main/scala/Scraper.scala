package com.jobgun.aggregator.craigslist

import org.openqa.selenium.{By, WebDriverException}
import org.openqa.selenium.firefox.FirefoxDriver

import zio._
import zio.selenium._

object Scraper {
    val scraper = (link: String) => for {
      _        <- WebDriver.get(link)
      _        <- Clock.sleep(2.seconds)
      results  <- WebDriver.findElements(By.className("result-thumb"))
      _        <- Console.printLine(results.mkString("\n"))
      links    <- ZIO.collectAll(results.map(_.getAttribute("href")))
    } yield links
}