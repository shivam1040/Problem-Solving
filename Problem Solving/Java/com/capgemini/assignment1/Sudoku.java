package com.capgemini.assignment1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sudoku {

	void generator() {
		Integer sudokuMatrix[][]=new Integer[9][9];
		List<Integer> row=new ArrayList<Integer>();
		List<Integer> column=new ArrayList<Integer>();
		List<Integer> block=new ArrayList<Integer>();
		boolean notDone=true;
		int rIndex=0;
		int cIndex=0;
		int rBlock=0;
		int cBlock=0;
		int blockId=1;
		int rBlockId=0;
		int eleInserted=0;
		int max=10, min=1;
		int n=(int) ((Math.random() * (max - min)) + min);
		while(notDone) {
			if(n>9)
				n=1;
		sudokuMatrix[rIndex][cIndex]=n;
		
		for(int i=0; i<9; i++) { //lines from 27-36 to ensure no repetition in row
			row.add(sudokuMatrix[rIndex][i]);
		}
		boolean rowCheck=Collections.frequency(row, n)<2?true:false;
		if(!rowCheck) {
			row.clear();
			n++;
			continue;
		}
		row.clear();
		
		for(int i=0; i<9; i++) { //lines from 38-47 to ensure no repetition in column
			column.add(sudokuMatrix[i][cIndex]);
		}
		boolean columnCheck=Collections.frequency(column, n)<2?true:false;
		if(!columnCheck) {
			column.clear();
			n++;
			continue;
		}
		column.clear();
		
		for(int i=0; i<3; i++) { //lines from 49-66 to ensure no repetition in block
			block.add(sudokuMatrix[rBlock][cBlock++]);
			block.add(sudokuMatrix[rBlock][cBlock++]);
			block.add(sudokuMatrix[rBlock][cBlock++]);
			rBlock++;
			cBlock=blockId-1;
		}
		boolean blockCheck=Collections.frequency(block, n)<2?true:false;
		if(!blockCheck) {
			rBlock=rBlockId;
			block.clear();
			n++;
			continue;
		}
		else {
			rBlock=rBlockId;
		}
		block.clear();
		
		if(blockCheck==true && columnCheck==true && rowCheck==true) { //lines from 68-97 to update indexes/counters
			if(cIndex>=8 && rIndex>=8) {
				notDone=false;
				break;
			}
			if((cIndex+1)%3==0 && cIndex>1) {
				cIndex=blockId-1;
				rIndex++;
			}
			else {
			cIndex++;
			}
			eleInserted++;
			n++;
			if(rIndex>8) {
				rIndex=0;
				blockId+=3;
				cIndex=blockId-1;
			}
			if(eleInserted%9==0 && eleInserted>0) {
				rBlockId+=3;
				rBlock=rBlockId;
				eleInserted=0;
			}
			if(rBlockId>6) {
				rBlockId=0;
				rBlock=rBlockId;
			}
		}
		}
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(sudokuMatrix[i][j]+" ");
				if(j>1 && (j+1)%3==0)
					System.out.print("\t");
			}
			System.out.println();
			if(i>1 && (i+1)%3==0) 
				System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sudoku obj1=new Sudoku();
		obj1.generator();
	}

}