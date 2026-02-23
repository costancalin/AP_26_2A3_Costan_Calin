void main(String[] args)
{
    if (args.length < 2)
    {
        System.out.println("eroare argumente lipsa");
        return;
    }

    int n = Integer.parseInt(args[0]);
    String forma = args[1];


    int[][] grid = new int[n][n];
    long inceput = System.nanoTime();


    if (forma.equalsIgnoreCase("dreptunghi"))
    {
        genereazaDreptunghi(grid, n);
    }
    else if (forma.equalsIgnoreCase("cerc"))
    {
        genereazaCerc(grid, n);
    }

    long sfarsit = System.nanoTime();


    if (n <= 30)
    {
        String rezultatVizual = transformaInString(grid);
        System.out.print(rezultatVizual);
    }
    else
    {
        System.out.println("T: " + (sfarsit - inceput) + " ms");
    }
}


void genereazaDreptunghi(int[][] mat, int latime)
{
    for (int r = 0; r < latime; r++)
    {
        for (int c = 0; c < latime; c++)
        {
            if (r > latime / 4 && r < 3 * latime / 4 && c > latime / 4 && c < 3 * latime / 4)
            {
                mat[r][c] = 0;
            }
            else
            {
                mat[r][c] = 255;
            }
        }
    }
}


void genereazaCerc(int[][] mat, int latime)
{
    int centrul = latime / 2;
    int raza = latime / 3;
    for (int y = 0; y < latime; y++)
    {
        for (int x = 0; x < latime; x++)
        {
            int dist_x = x - centrul;
            int dist_y = y - centrul;
            if (dist_x * dist_x + dist_y * dist_y <= raza * raza)
            {
                mat[y][x] = 255; // Alb
            }
            else
            {
                mat[y][x] = 0; // Negru
            }
        }
    }
}


String transformaInString(int[][] mat)
{
    StringBuilder builder = new StringBuilder();
    for (int[] rand : mat)
    {
        for (int pixel : rand)
        {
            if (pixel == 0)
            {
                builder.append("██");
            }
            else
            {
                builder.append("  ");
            }
        }
        builder.append("\n");
    }
    return builder.toString();
}