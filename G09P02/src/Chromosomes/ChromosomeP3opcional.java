package Chromosomes;

import java.util.Random;

public class ChromosomeP3opcional extends Chromosome<Integer, Integer> {	
	private String fenotype = "";
	
	//CHROMOSOME LENGTH ES CONFIGURABLE DESDE EL EDITOR	
	public ChromosomeP3opcional(int chromosomeLenght, double tolerance) {
		super(chromosomeLenght, tolerance);
		//Chromosome calls initGenes & calculateFenotypes
	}
	
	@Override
	public int compareTo(Chromosome other)
	{
		return Double.compare(this.fitness, other.getFitness());
	}
	
	@Override
	protected void initGenes() {
		//EACH GENE IS FORMED BY 1 REAL NUMBER | ALLELE ONLY
		final int tam_genes_x = 1; //this.calculateGenSize(this.tolerance, min_x, max_x);
		
		Random rand = new Random();

		// Random init each gene
		for (int i = 0; i < this.num_of_genes; i++) {
			this.genes[i] = new Gene<Integer>(tam_genes_x);
			
			for (int j = 0; j < this.genes[i].getLenght(); j++) {
				//Each genes has only 1 allele
				this.genes[i].setAllele(j, rand.nextInt(256)); // [0, 255]
			}
		}
	}

	@Override
	public void calculateFenotypes() {
		System.out.println(genes.length);
		int index = genes[0].getAllele(0) % start.length;
		fenotype = start[index];
		boolean full = false;
		String solution = "";
		String chosen_array = "";
		char letter = ' ';
		
		for (int g = 1; g < num_of_genes && !full; g++) {
			// SEARCH FOR < ============================================
			int j = 0;			
			letter = fenotype.charAt(j);
			while (j < fenotype.length() &&  letter != '<') {
				letter = fenotype.charAt(j);
				
				if (letter != '<')
					solution += letter;
				j++;
			}
			
			// SEAR FOR RULE BETWEEN <>==================================
			if(j < fenotype.length()) {
				j++; // skip "<"
				letter = fenotype.charAt(j);
				while (j < fenotype.length() && letter != '>') {
					letter = fenotype.charAt(j);
					chosen_array += letter;
					j++;
				}
				
				if (j < fenotype.length()) { //found >
					j++; // skip ">"
					int c = genes[g].getAllele(0);
					int r = 1;
					String value = "";
					switch(chosen_array) {
					case "expr":
						r = expr.length;
						value = expr[c % r];
						break;
					case "op":
						r = op.length;
						value = op[c % r];
						break;
					case "term":
						r = term.length;
						value = term[c % r];
						break;
					case "digit":
						r = term.length;
						value = digit[c % r];
						break;
					default:
						System.out.println("Error in calculateFenotypes" + fenotype);
						break;
					}
					
					System.out.println(value);
					solution += value;
				}
				
				// FILL SOLUTION WITH TEXT AFTER >=======================================0
				while (j < fenotype.length()) {
					solution += fenotype.charAt(j);;
					j++;
				}
					
			}
			else full = true;
		}
		
		System.out.println("FENOTTYPE");
		System.out.println(fenotype);
		
		//HABRIA QUE METER EL WRAPPING =====================================================
		
//		fenotypes = new Integer[num_of_genes];
//		
//		for (int i = 0; i < num_of_genes; i++) {
//			// EACH GENE CONTAINS ONLY 1 ALLELE. FENOTYPE = VALUE IN ALLELE
//			fenotypes[i] = genes[i].getAllele(0);
//		}
	}

	@Override
	public double evaluate() {
//		if (fenotypes.length == num_of_genes) { 
//			brute_fitness = 0;
//			
//			// RELLENAR-----------------------------------
//			
//		} else {
//			brute_fitness = Double.MAX_VALUE; // default value,if fails, wortst value
//			System.out.println("Ejer 4: Wrong number of fitness params.");
//		}
		brute_fitness = 0;
		return brute_fitness;
	}
	
	@Override
	public boolean mutateGene(int pos, Random rand, double mutation_chance) {
		boolean cambios = false;
		
		if(0 <= pos && pos < num_of_genes){
			for (int j = 0; j < this.genes[pos].getLenght(); j++) {
				if (rand.nextDouble() * 100 < mutation_chance) {
					this.genes[pos].setAllele(j, rand.nextInt(256)); // [0, 255]
					cambios = true;
				}				
			}
		}	
		return cambios;
	}

	@Override
	protected Chromosome getNewInstance() {
		return new ChromosomeP3opcional(this.num_of_genes, this.tolerance);
	}

	
}