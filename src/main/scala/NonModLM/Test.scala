package NonModLM

import NonModLM.Print._
import NonModLM.arith.{ArithParsers, ArithPrinter}
import NonModLM.bot.{BotParsers, BotPrinter}
import NonModLM.equirec.{EquiRecParsers, EquiRecPrinter}
import NonModLM.fullequirec.{FullEquiRecParsers, FullEquiRecPrinter}
import NonModLM.fullerror.{FullErrorParsers, FullErrorPrinter}
import NonModLM.fullisorec.{FullIsoRecParsers, FullIsoRecPrinter}
import NonModLM.fullomega.{FullOmegaParsers, FullOmegaPrinter}
import NonModLM.fullpoly.{FullPolyParsers, FullPolyPrinter}
import NonModLM.fullrecon.{FullReconParsers, FullReconPrinter}
import NonModLM.fullref.{FullRefParsers, FullRefPrinter}
import NonModLM.fullsimple.{FullSimpleParsers, FullSimplePrinter}
import NonModLM.fullsub.{FullSubParsers, FullSubPrinter}
import NonModLM.fulluntyped.{FullUntypedParsers, FullUntypedPrinter}
import NonModLM.rcdsubbot.{RcdSubBotParsers, RcdSubBotPrinter}
import NonModLM.recon.{ReconParsers, ReconPrinter}
import NonModLM.simplebool.{SimpleBoolParsers, SimpleBoolPrinter}
import NonModLM.tyarith.{TyArithParsers, TyArithPrinter}
import NonModLM.untyped.{UntypedParsers, UntypedPrinter}

import scala.io.{Source, StdIn}
import scala.text.Document

object Test {

  def runTest(name: String, f: => (String => Unit)): Unit = {
    val inputFile = "examples/" + name + ".tapl"
    val lines: List[String] = Source.fromFile(inputFile).getLines().toList
    val t0 = System.nanoTime()
    lines.foreach(f)
    val t1 = System.nanoTime()
    println((t1 - t0) / 1000000)
  }

  def parseAndPrint[E](parse: String => E, print: E => Document)(inp: String): Unit = {
    val width = 60
    val e = parse(inp)
    println(printDoc(print(e), width))
  }

  def main(args: Array[String]): Unit = {
    print("Calculus name: ")
    val name = StdIn.readLine().toLowerCase

    val fn: String => Unit = name match {
      case "arith" => parseAndPrint(ArithParsers.input, ArithPrinter.ptm)
      case "untyped" => parseAndPrint(UntypedParsers.input, UntypedPrinter.ptm)
      case "fulluntyped" => parseAndPrint(FullUntypedParsers.input, FullUntypedPrinter.ptm)
      case "tyarith" => parseAndPrint(TyArithParsers.input, TyArithPrinter.ptm)
      case "simplebool" => parseAndPrint(SimpleBoolParsers.input, SimpleBoolPrinter.ptm)
      case "fullsimple" => parseAndPrint(FullSimpleParsers.input, FullSimplePrinter.ptm)
      case "bot" => parseAndPrint(BotParsers.input, BotPrinter.ptm)
      case "fullref" => parseAndPrint(FullRefParsers.input, FullRefPrinter.ptm)
      case "fullerror" => parseAndPrint(FullErrorParsers.input, FullErrorPrinter.ptm)
      case "rcdsubbot" => parseAndPrint(RcdSubBotParsers.input, RcdSubBotPrinter.ptm)
      case "fullsub" => parseAndPrint(FullSubParsers.input, FullSubPrinter.ptm)
      case "fullequirec" => parseAndPrint(FullEquiRecParsers.input, FullEquiRecPrinter.ptm)
      case "fullisorec" => parseAndPrint(FullIsoRecParsers.input, FullIsoRecPrinter.ptm)
      case "equirec" => parseAndPrint(EquiRecParsers.input, EquiRecPrinter.ptm)
      case "recon" => parseAndPrint(ReconParsers.input, ReconPrinter.ptm)
      case "fullrecon" => parseAndPrint(FullReconParsers.input, FullReconPrinter.ptm)
      case "fullpoly" => parseAndPrint(FullPolyParsers.input, FullPolyPrinter.ptm)
      case "fullomega" => parseAndPrint(FullOmegaParsers.input, FullOmegaPrinter.ptm)
      case _ => sys.error("Incorrect name")
    }
    runTest(name, fn)
  }
}
