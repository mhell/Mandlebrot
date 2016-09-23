import java.util.Stack;

/**
 * An image sector
 */
public class Sector {
	private int min_re; 
	private int max_re;
	private int min_im;
	private int max_im;
	private int x_size;
	private int y_size;

	/**
	 * 
	 */
	public Sector(int min_re, int max_re, int min_im, int max_im, int x_size, int y_size) {
		this.min_re = min_re;
		this.max_re = max_re;
		this.min_im = min_im;
		this.max_im = max_im;
		this.x_size = x_size;
		this.y_size = y_size;
	}

	public String toString() {
		return "min_re:" + min_re + " max_re:" + max_re + " min_im:" + min_im +
			   " max_im:" + max_im + " x_size:" + x_size + " y_size:" + y_size;
	}

	/**
 	 * Creates a stack of sectors
	 *
	 * @param min_re 	lower bound real part of a Mandelbrot set region
 	 * @param max_re 	upper bound real part of a Mandelbrot set region
 	 * @param min_im 	lower bound imaginary part of a Mandelbrot set region
 	 * @param max_im 	upper bound imaginary part of a Mandelbrot set region
 	 * @param x_size	width of render image 
 	 * @param y_size 	height of render image
 	 * @param divs 		size of sectors to create
 	 * @return the stack of sectors
 	 */
	public static Stack<Sector> makeSectors(int min_re, int max_re, int min_im, int max_im, int x_size, int y_size, int divs) {
		Stack<Sector> sectors = new Stack<Sector>();
		//double mandDivs = divs*divs / (x*y) * ((max_r-min_r) * (max_i-min_i)) // the corresponding div size in the Mandelbrot region

		for (int im=min_im; im < max_im; im+=divs) {
			for (int re=min_re; re < max_re; re+=divs)  {
				int re2 = re + divs < max_re ? re + divs : re + (max_re-re); 
				int im2 = im + divs < max_im ? im + divs : im + (max_im-im); 
				int x_size2 = re + divs < max_re ? divs : x_size % divs;
				int y_size2 = im + divs < max_im ? divs : y_size % divs;
				sectors.push(new Sector(re, re2, im, im2, x_size2, y_size2));
			}
		}
		return sectors;
	}

	public static void main(String[] args) {
		/*Stack<Sector> sectors = makeSectors(0, 5, 0, 5, 5, 5, 2);

		for (Sector s : sectors) {
			System.out.println(s.toString());
		}*/

		double min_r = 0.0;
		double max_r = 50.0;
		double min_i = 0.0; 
		double max_i = 50.0;
		double x = 5.0;
		double y = 5.0;
		double divs = 2.0;

		System.out.println(divs*divs / (x*y) * ((max_r-min_r) * (max_i-min_i)));

	}
}





