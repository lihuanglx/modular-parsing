package ModClass

import ModClass.Arith.TestArith
import ModClass.Bot.TestBot
import ModClass.EquiRec.TestEquiRec
import ModClass.FullEquiRec.TestFullEquiRec
import ModClass.FullError.TestFullError
import ModClass.FullIsoRec.TestFullIsoRec
import ModClass.FullOmega.TestFullOmega
import ModClass.FullPoly.TestFullPoly
import ModClass.FullRecon.TestFullRecon
import ModClass.FullRef.TestFullRef
import ModClass.FullSimple.TestFullSimple
import ModClass.FullSub.TestFullSub
import ModClass.FullUntyped.TestFullUntyped
import ModClass.RcdSubBot.TestRcdSubBot
import ModClass.Recon.TestRecon
import ModClass.SimpleBool.TestSimpleBool
import ModClass.TyArith.TestTyArith
import ModClass.Untyped.TestUntyped

import scala.io.{Source, StdIn}

object Test {

  def runTest(name: String, f: => (String => Unit)): Unit = {
    val inputFile = "examples/" + name + ".tapl"
    val lines: List[String] = Source.fromFile(inputFile).getLines().toList
    val t0 = System.nanoTime()
    lines.foreach(f)
    val t1 = System.nanoTime()
    println((t1 - t0) / 1000000)
  }

  def main(args: Array[String]): Unit = {
    print("Calculus name: ")
    val name = StdIn.readLine()

    val fn: String => Unit = name match {
      case "arith" => TestArith.parseAndPrint
      case "untyped" => TestUntyped.parseAndPrint
      case "fulluntyped" => TestFullUntyped.parseAndPrint
      case "tyarith" => TestTyArith.parseAndPrint
      case "simplebool" => TestSimpleBool.parseAndPrint
      case "fullsimple" => TestFullSimple.parseAndPrint
      case "bot" => TestBot.parseAndPrint
      case "fullref" => TestFullRef.parseAndPrint
      case "fullerror" => TestFullError.parseAndPrint
      case "rcdsubbot" => TestRcdSubBot.parseAndPrint
      case "fullsub" => TestFullSub.parseAndPrint
      case "fullequirec" => TestFullEquiRec.parseAndPrint
      case "fullisorec" => TestFullIsoRec.parseAndPrint
      case "equirec" => TestEquiRec.parseAndPrint
      case "recon" => TestRecon.parseAndPrint
      case "fullrecon" => TestFullRecon.parseAndPrint
      case "fullpoly" => TestFullPoly.parseAndPrint
      case "fullomega" => TestFullOmega.parseAndPrint
      case _ => sys.error("Incorrect name")
    }
    runTest(name, fn)
  }

}
