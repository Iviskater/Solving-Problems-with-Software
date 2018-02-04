import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {

// Get the total perimeter of the shape
public double getPerimeter (Shape s) {
	// Start with totalPerim = 0
	double totalPerim = 0.0;
	// Start wth prevPt = the last point
	Point prevPt = s.getLastPoint();
	// For each point currPt in the shape,
	for (Point currPt : s.getPoints()) {
		// Find distance from prevPt point to currPt
		double currDist = prevPt.distance(currPt);
		// Update totalPerim by currDist
		totalPerim = totalPerim + currDist;
		// Update prevPt to be currPt
		prevPt = currPt;
	}
	// totalPerim is the answer
	return totalPerim;
}
// Number of points of the shape
public int getNumPoints (Shape s) {
	// Put code here
	int totalPoints = 0;
	for (Point currpt:s.getPoints()) {
		totalPoints++;
	}
	return totalPoints;
}
// Average side of the shape
public double getAverageLength(Shape s) {

	double averageShape= getPerimeter(s)/getNumPoints(s);
	return averageShape;
}
// Largest side of the shape
public double getLargestSide(Shape s) {

	double largest_side= 0;
	Point prevPt = s.getLastPoint();

	for (Point currPt :s.getPoints()) {
		double curr_dist= prevPt.distance(currPt);
		if(curr_dist>largest_side) {
			largest_side=curr_dist;
		}
		prevPt=currPt;
	}
	return largest_side;
}

// X Value the largest
public int getLargestX(Shape s) {

	int largest_X= 0;

	for (Point currPt :s.getPoints()) {
		int curr_X = currPt.getX();
		if(curr_X>largest_X) {
			largest_X=curr_X;
		}
	}
	return largest_X;
}
//Get perimeter of each file printed
public double getPerimeterMultipleFiles() {
	DirectoryResource dr = new DirectoryResource();
	double largest_Perim=0.0;

	for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
		Shape s = new Shape(fr);
		double length = getPerimeter(s);
		System.out.println("Length File"+f.getName()+" = "+length);
	}

	return largest_Perim;
}
//Get the largest perimeter of multiple files
public double getLargestPerimeterMultipleFiles() {
	DirectoryResource dr = new DirectoryResource();
	double largest_Perim=0.0;

	for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
		Shape s = new Shape(fr);
		double length = getPerimeter(s);
		if(length>largest_Perim) largest_Perim=length;
	}

	return largest_Perim;
}

// Get the file with Largest Perimeter
public String getFileWithLargestPerimeter() {
	DirectoryResource dr = new DirectoryResource();
	File temp = null;
	double largest_Perim=0.0;

	for (File f : dr.selectedFiles()) {
		FileResource fr = new FileResource(f);
		Shape s = new Shape(fr);
		double length = getPerimeter(s);
		if(length>largest_Perim) {
			largest_Perim=length;
			temp=f;
		}
	}
	return temp.getName();
}

// This method creates a triangle that you can use to test your other methods
public void triangle(){
	Shape triangle = new Shape();
	triangle.addPoint(new Point(0,0));
	triangle.addPoint(new Point(6,0));
	triangle.addPoint(new Point(3,6));
	for (Point p : triangle.getPoints()) {
		System.out.println(p);
	}
	double peri = getPerimeter(triangle);
	System.out.println("perimeter = "+peri);
}

// This method prints names of all files in a chosen folder that you can use to test your other methods
public void printFileNames() {
	DirectoryResource dr = new DirectoryResource();
	for (File f : dr.selectedFiles()) {
		System.out.println(f);
	}
}

public void testPerimeter () {
	FileResource fr = new FileResource();
	Shape s = new Shape(fr);
	double length = getPerimeter(s);
	double largest_side = getLargestSide(s);
	double average_side = this.getAverageLength(s);
	int largest_X = this.getLargestX(s);
	System.out.println("Perimeter =\n" +length);
	System.out.println("Largest Side =\n" +largest_side);
	System.out.println("Average Side =\n" +average_side);
	System.out.println("Largest X =\n" +largest_X);

}

public void testMultiplePerimeterFiles (){

	//Delete "//" to test different methods

//        double perimeter_Files = this.getPerimeterMultipleFiles();

//        double multiple_largestPerim = this.getLargestPerimeterMultipleFiles();
//        System.out.println("Largest Perimeter Multiple files =\n" +multiple_largestPerim);

	String multiple_largestPerim_File = this.getFileWithLargestPerimeter();
	System.out.println("Largest File Perimeter =\n" +multiple_largestPerim_File);

}

public static void main (String[] args) {
	PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
	//pr.testPerimeter();
	pr.testMultiplePerimeterFiles();
}
}
