package Main;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import Chromosomes.ChromosomeP3;
import Utils.ArrayUtils;
import Utils.MathUtils;
import Utils.RandomUtils;
import View.MainView;

public class main {
	public static void main(String args[]) {

//		ChromosomeP3 a = new ChromosomeP3(10, 3, "COMPLETA");
//		ChromosomeP3 b = new ChromosomeP3(10, 3, "COMPLETA");
//		BinaryTree a_tree = a.getTree();
//		BinaryTree b_tree = b.getTree();
//		
//		System.out.println(a_tree.toArray());
//		System.out.println(b_tree.toArray());
//		
//		System.out.println(a_tree.getRoot());
//		System.out.println(b_tree.getRoot());
//		
//		TreeCross cross = new TreeCross();		
//		cross.crossPRUEBA(a, b);
//		
//		System.out.println("NUEVO ARBOL");
//		a_tree = a.getTree();
//	    b_tree = b.getTree();
//		
//		System.out.println(a_tree.toArray());
//		System.out.println(b_tree.toArray());

//		 ArrayList<String> arr = new ArrayList<>(Arrays.asList("0", "mul", "x", "mul", "-2", "add", "x", "sub", "-1", "mul", "1", "add", "x", "mul", "-2", "sub", "x", "sub", "0", "sub", "-1"));
//		 System.out.println(arr);
//		 System.out.println(ArrayUtils.arrayToMathExpression(arr));
		// El resultado qeu deberia dar (que aun no lo da porque no está completo) es
		// -2x + 2

		new MainView();
	}
}
