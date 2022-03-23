package feeders

import com.typesafe.scalalogging.Logger
import org.slf4j.LoggerFactory

import java.text.SimpleDateFormat
import java.util.Calendar


object TestFeeders {

  val LOG = Logger(LoggerFactory.getLogger("Feeders"))

  def toDateString(): String={
    val calendar = Calendar.getInstance;
    new SimpleDateFormat("YYYY-MM-dd").format(Calendar.getInstance().getTime());
  }

  def fromDateString(): String={
    val calendar = Calendar.getInstance;
    calendar.set(Calendar.DATE, -30);
    new SimpleDateFormat("YYYY-MM-dd").format(Calendar.getInstance().getTime());
  }
}
