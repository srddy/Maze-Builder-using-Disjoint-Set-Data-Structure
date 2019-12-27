public class Maze
{
    class Block
    {
        public boolean down;
        public boolean right;

        public Block()
        {
            down = true;
            right = true;
        }

        public void printBlock()
        {
            if(down) {
                System.out.print("_");
            }
            else {
                System.out.print(" ");
            }
            if(right) {
                System.out.print("|");
            }
            else {
                System.out.print(" ");
            }
        }
    }

    private Block[] self;
    private int col;
    private int len;

    public Maze(int rows, int cols)
    {
        this.col = cols;
        this.len = rows * cols;
        this.self = new Block[this.len];

        for(int i = 0; i < this.len; i++)
        {
            self[i] = new Block();
        }

        DisjSets dset = new DisjSets(len);

        for(int idx = 1; idx <= len - 1;  )
        {
            for(boolean flag = false; !flag; )
            {
                int i = (int) (Math.random() * len);
                int j, k;
                if(i == 0)
                {
                    k = (int)(Math.random() * 2);
                    if(k == 0)
                        j = i + 1;
                    else
                        j = i + cols;
                }
                else if(i == cols - 1)
                {
                    k = (int)(Math.random() * 2);
                    if(k == 0)
                        j = i - 1;
                    else
                        j = i + cols;
                }
                else if(i == len - cols)
                {
                    k = (int)(Math.random() * 2);
                    if(k == 0)
                        j = i - cols;
                    else
                        j = i + 1;
                }
                else if(i == len - 1)
                {
                    k = (int)(Math.random() * 2);
                    if(k == 0)
                        j = i - 1;
                    else
                        j = i - cols;
                }
                else if(i > 0 && i < cols - 1)
                {
                    k = (int)(Math.random() * 3);
                    if(k == 0)
                        j = i - 1;
                    else if(k == 1)
                        j = i + 1;
                    else
                        j = i + cols;
                }
                else if(i % cols == 0)
                {
                    k = (int)(Math.random() * 3);
                    if(k == 0)
                        j = i - cols;
                    else if(k == 1)
                        j = i + 1;
                    else
                        j = i + cols;
                }
                else if(i > len - cols && i < len - 1)
                {
                    k = (int)(Math.random() * 3);
                    if(k == 0)
                        j = i - cols;
                    else if(k == 1)
                        j = i - 1;
                    else
                        j = i + 1;
                }
                else if(i % cols == cols - 1)
                {
                    k = (int)(Math.random() * 3);
                    if(k == 0)
                        j = i - cols;
                    else if(k == 1)
                        j = i - 1;
                    else
                        j = i + cols;
                }
                else
                {
                    k = (int)(Math.random() * 4);
                    if(k == 0)
                        j = i - cols;
                    else if(k == 1)
                        j = i - 1;
                    else if(k == 2)
                        j = i + 1;
                    else
                        j = i + cols;
                }
                int s1 = dset.find(i);
                int s2 = dset.find(j);
                if(s1 != s2)
                {
                    dset.union(s1, s2);
                    if(j == i - cols)
                        this.self[j].down = false;
                    else if(j == i - 1)
                        this.self[j].right = false;
                    else if(j == i + 1)
                        this.self[i].right = false;
                    else if(j == i + cols)
                        this.self[i].down = false;
                    flag = true;
                    idx++;
                }
            }
        }
    }

    public void printMaze()
    {
        System.out.print("  ");

        for(int i = 1; i < this.col; i++)
        {
            System.out.print(" _");
        }
        System.out.println();

        for(int i = 0; i < this.len - 1; i++)
        {
            if(i % this.col == 0)
            {
                if(i == 0)
                    System.out.print(" ");
                else
                    System.out.print("|");
            }

            this.self[i].printBlock();

            if(i % this.col == this.col - 1)
            {
                System.out.println();
            }
        }
    }
}