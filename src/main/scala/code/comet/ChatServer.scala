package code
package comet

import net.liftweb._
import http._
import actor._

/**
 * Singleton providing chat features for all clients. Actor so it's
 * thread-safe.
 */
object ChatServer extends LiftActor with ListenerManager {
  private var msgs = Vector("Welcome") // private state

  /**
   * When listeners are updated, what messages are sent?
   * Send msgs which is immutable and can be shared.
   */
  def createUpdate = msgs

  /**
   * Process incoming messages. Look for strings, add them to
   * msgs and send out to listeners.
   */
  override def lowPriority = {
    case s: String => msgs :+= s; updateListeners()
  }
}

