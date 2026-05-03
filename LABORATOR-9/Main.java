import java.util.*;

class Cell {
    int r, c;
    public Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class SharedMemory {
    private String bunnyLastSeen = "unknown";

    public synchronized void updateBunnyLocation(int r, int c) {
        this.bunnyLastSeen = r + "," + c;
    }

    public synchronized String getBunnyLocation() {
        return bunnyLastSeen;
    }
}

class Maze {
    int rows, cols;
    boolean[][] occupied;
    Cell exit;
    volatile boolean running = true;

    public Maze(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.occupied = new boolean[rows][cols];
        this.exit = new Cell(rows - 1, cols - 1);
    }

    public synchronized boolean canMoveTo(int r, int c, boolean isRobot) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        if (isRobot && occupied[r][c]) return false;
        return true;
    }

    public synchronized void updatePosition(int oldR, int oldC, int newR, int newC, boolean isRobot) {
        if (isRobot) {
            occupied[oldR][oldC] = false;
            occupied[newR][newC] = true;
        }
    }

    public void stopGame() {
        this.running = false;
    }
}

class Bunny implements Runnable {
    int r, c;
    Maze maze;
    Random rand = new Random();

    public Bunny(Maze maze) {
        this.maze = maze;
        this.r = 0;
        this.c = 0;
    }

    @Override
    public void run() {
        while (maze.running) {
            int dr = rand.nextInt(3) - 1;
            int dc = rand.nextInt(3) - 1;

            if (maze.canMoveTo(r + dr, c + dc, false)) {
                r += dr;
                c += dc;
            }

            if (r == maze.exit.r && c == maze.exit.c) {
                System.out.println("Bunny a ajuns la iesire! Iepurasul a castigat.");
                maze.stopGame();
            }

            try { Thread.sleep(300); } catch (InterruptedException e) {}
        }
    }
}

class Robot implements Runnable {
    int r, c;
    String name;
    Maze maze;
    Bunny bunny;
    SharedMemory memory;
    Random rand = new Random();

    public Robot(String name, Maze maze, Bunny bunny, SharedMemory memory) {
        this.name = name;
        this.maze = maze;
        this.bunny = bunny;
        this.memory = memory;
        do {
            this.r = rand.nextInt(maze.rows);
            this.c = rand.nextInt(maze.cols);
        } while (maze.occupied[r][c] || (r == bunny.r && c == bunny.c));
        maze.occupied[r][c] = true;
    }

    @Override
    public void run() {
        while (maze.running) {
            int dr = rand.nextInt(3) - 1;
            int dc = rand.nextInt(3) - 1;

            if (maze.canMoveTo(r + dr, c + dc, true)) {
                maze.updatePosition(r, c, r + dr, c + dc, true);
                r += dr;
                c += dc;
            }

            if (Math.abs(r - bunny.r) <= 1 && Math.abs(c - bunny.c) <= 1) {
                memory.updateBunnyLocation(bunny.r, bunny.c);
            }

            if (r == bunny.r && c == bunny.c) {
                System.out.println(name + " a prins iepurasul! Robotii au castigat.");
                maze.stopGame();
            }

            try { Thread.sleep(400); } catch (InterruptedException e) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int size = 15;
        Maze maze = new Maze(size, size);
        SharedMemory memory = new SharedMemory();
        
        Bunny bunny = new Bunny(maze);
        List<Robot> robots = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            robots.add(new Robot("Robot-" + i, maze, bunny, memory));
        }

        new Thread(bunny).start();
        for (Robot r : robots) {
            new Thread(r).start();
        }

        new Thread(() -> {
            while (maze.running) {
                printMaze(maze, bunny, robots);
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            }
        }).start();
    }

    private static void printMaze(Maze maze, Bunny bunny, List<Robot> robots) {
        StringBuilder sb = new StringBuilder("\n");
        for (int i = 0; i < maze.rows; i++) {
            for (int j = 0; j < maze.cols; j++) {
                if (i == bunny.r && j == bunny.c) sb.append("B ");
                else if (i == maze.exit.r && j == maze.exit.c) sb.append("E ");
                else {
                    boolean isRobot = false;
                    for (Robot r : robots) {
                        if (r.r == i && r.c == j) {
                            sb.append("R ");
                            isRobot = true;
                            break;
                        }
                    }
                    if (!isRobot) sb.append(". ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}