// vim: filetype=scala
package code
package comet

import net.liftweb._
import http._
import util._
import Helpers._

/**
 * Changes in this component's state are automatically reflected in the
 * browser.
 */
class Chat extends CometActor with CometListener {
	private var msgs: Vector[String] = Vector() // private state here

	// register as a listener on the chatserver
	def registerWith = ChatServer

	/**
	 * CometActors are actors that process messages. We listen for
	 * Vector[String] and re-render when we get some.
	 */
	override def lowPriority = {
		case v: Vector[String] => msgs = v; reRender()	
	}

	/**
	 * Put messages in li's and clear clearable elements.
	 */
	def render = "li *" #> msgs & ClearClearable
}
