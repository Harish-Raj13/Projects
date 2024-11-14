import java.util.*;

class Game{
    static char board[][];
    Game()
    {
        board = new char[3][3];
        initial();
    }
    public static void placeMark(int row, int col, char mark)
    {
        board[row][col] = mark;
    }
    public static void initial()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                board[i][j] = ' ';
            }
        }
    }
    public static boolean rowWin()
    {
        for(int i=0;i<3;i++)
        {
            if(board[i][0]!=' ' && board[i][0]==board[i][1] && board[i][1]==board[i][2])
            {
                return true;
            }
        }
        return false;
    }

    public static boolean colWin()
    {
        for(int i=0;i<3;i++)
        {
            if(board[0][i]!=' ' && board[0][i]==board[1][i] && board[1][i]==board[2][i])
            {
                return true;
            }
        }
        return false;
    }

    public static boolean diaWin()
    {
        if(board[0][0]!=' ' && board[0][0]==board[1][1] && board[1][1]==board[2][2])
        {
            return true;
        }
        if(board[0][2]!=' ' && board[0][2]==board[1][1] && board[1][1]==board[2][0])
        {
            return true;
        }
        return false;
    }

    public void display()
    {
        System.out.println("-------------");
        for(int i=0;i<3;i++)
        {
            System.out.print("| ");
            for(int j=0;j<3;j++)
            {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}

abstract class Player{
    String name;
    char mark;
    abstract public void input();

    public static boolean validcheck(int row, int col)
    {
        if(row<0 || row>=3 || col<0 || col>=3)
        {
            return false;
        }
        if(Game.board[row][col] ==' ')
        {
            return true;
        }
        return false;
    }
}

class Human extends Player{
    Human(String name,char mark)
    {
        this.name = name;
        this.mark = mark;
    }
    public void input()
    {
        Scanner sc = new Scanner(System.in);
        int row, col;
        do{
            System.out.println("Enter the row and col: ");
            row = sc.nextInt();
            col = sc.nextInt();
        }while(!validcheck(row, col));
        Game.placeMark(row, col, mark);
    }
}

class Robo extends Player{
    Robo(String name, char mark)
    {
        this.name = name;
        this.mark = mark;
    }

    public void input()
    {
        Random r = new Random();
        int row, col;
        do{
            row = r.nextInt(3);
            col = r.nextInt(3);
        }while(!validcheck(row, col));
        Game.placeMark(row, col, mark);
    }
}


class Main{
    public static void main(String[]args)
    {
        Game g = new Game();
        Human h1 = new Human("Harish", 'X');
        Robo r = new Robo("Robo",'O');
        Player cp = h1;

        while(true)
        {
            g.display();
            System.out.println(cp.name + " 's turn");
            cp.input();
            if(g.rowWin() || g.colWin() || g.diaWin())
            {
                g.display();
                System.out.println(cp.name + " has won");
                break;
            }
            if(cp ==h1)
            {
                cp = r;
            }
            else {
                cp = h1;
            }
        }
    }
}



