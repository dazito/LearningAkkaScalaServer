package com.dazito.scala.dakkabase

import akka.actor.Actor
import com.dazito.scala.dakkabase.messages.ParseArticle
import de.l3s.boilerpipe.extractors.ArticleExtractor

/**
 * Created by daz on 30/03/2016.
 */
class ArticleParserActor extends Actor {
    override def receive: Receive = {
        case html: String => val body: String = ArticleParser(html)
            sender() ! body
        case _ => println("Default case - no match!")
    }
}

object ArticleParser {
    def apply(html: String) : String = ArticleExtractor.INSTANCE.getText(html)
}
