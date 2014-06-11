import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//from ReadFile2LineClass05
public class ReadFile2Line17 {
	public static int word_count;
	public static int dimension;
	public static String[] word_list;
	public static float[][] vector;	
	public static void main(String[] args) {
		//File TextFile = new File("/home/xqcao/Downloads/aaaa.txt");不要这句，在args中出来
		File TextFile = new File(args[0]);
		readFile(TextFile);
		/*if (TextFile.exists() && TextFile.isFile()) {			
			System.out.println("i find the file! ");
			readFile(TextFile);
		}
		else {
			System.out.println("i can not find the file! ");
            return;
        }*/
	}
	public static void readFile(File TxtFile) {
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(TxtFile)); 
			int word_count = new Integer(br.readLine());
			int dimension = new Integer(br.readLine());			
			System.out.println("word_count ="+ word_count);
			System.out.println("dimension = " + dimension);	
			String line;
			float vector[][] = new float[word_count][dimension];
			int row = 0;
			String word_list[] = new String[word_count];
			while ( (line = br.readLine()) != null && line.length()!=0 ) {
			//while ( (line = br.readLine()) != null && !line.isEmpty() ) {
				String a[] = line.split(" ");
								word_list[row] = a[0];
				for(int i = 1; i < dimension+1; i++) {				
					vector[row][i-1] = new Float(a[i]);				
					}
				row++;
			}
			br.close();
			for(int k =0; k < word_count; k++){
				for(int j = 0; j < dimension; j++) {
					System.out.println("vector[" + k + "]["  + j + "] = " + vector[k][j]);
				}
				System.out.println("word_list = " + word_list[k]);
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}
