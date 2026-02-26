void main() {
    int n = 10;
    int m = 12;

    int[][] mat = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    int sus = n, jos = -1, st = m, dr = -1;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < m; j++)
        {
            if (mat[i][j] == 1)
            {
                if (i < sus) sus = i;
                if (i > jos) jos = i;
                if (j < st) st = j;
                if (j > dr) dr = j;
            }
        }
    }

    if (jos != -1) {
        System.out.println("sus: " + sus + " jos: " + jos + " stanga: " + st + " dreapta: " + dr);
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            System.out.print(mat[i][j] == 1 ? "█ " : "░ ");
        }
        System.out.println();
    }
}