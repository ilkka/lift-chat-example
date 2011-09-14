// vim: filetype=scala
package code
package snippet

import net.liftweb._
import http._
import js._
import JsCmds._
import JE._

import comet.ChatServer

/**
 * Snippets transform input to output, templates into dynamic content.
 */
object ChatIn {
	/**
	 * The render method returns a function that transforms NodeSeq ->
	 * NodeSeq. In this case it transforms a form input by attaching a
	 * behavior that sends the message to the ChatServer, then returns
	 * javascript to clear the input.
	 */
	def render = SHtml.onSubmit(s => {
		ChatServer ! s
		SetValById("chat_in", "")
	})
}
