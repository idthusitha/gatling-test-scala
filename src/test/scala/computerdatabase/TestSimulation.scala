package computerdatabase

import feeders.TestFeeders
import io.gatling.core.Predef._
import io.gatling.http.Predef._


class TestSimulation extends Simulation{

  val httpProtocol = http
    .baseUrl("http://test.com/customer-test")
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Test")
    .exec(http("request_test")
      .get("/api/v1/internal/statistics/classifications?brands=test&countries=GB&countries=US&from="+TestFeeders.fromDateString()+"&to="+TestFeeders.fromDateString()+"")
      .check(status.is(200)))
    .pause(7)
  setUp(scn.inject(atOnceUsers(1)).protocols(httpProtocol))

}
