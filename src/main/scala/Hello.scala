package com.jobgun.aggregator.craigslist

import org.openqa.selenium.{By, WebDriverException}
import org.openqa.selenium.firefox.FirefoxDriver

import zio._
import zio.selenium._

object FindElement extends ZIOAppDefault {

  val app: ZIO[WebDriver, Throwable, Unit] =
    for {
      // _        <- WebDriver.get("https://geo.craigslist.org/iso/us")
      // list     <- WebDriver.findElement(By.className("geo-site-list"))
      jobs     <- Scraper.scraper("https://atlanta.craigslist.org/search/hum#search=1~thumb~0~0")
      _        <- Console.printLine(jobs.mkString("\n"))
    } yield ()

  val layer: Layer[WebDriverException, WebDriver] = WebDriver.layer(new FirefoxDriver())

  override def run = app.provide(layer)
}
