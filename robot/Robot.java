public class Robot{
    private int X; // x axis
    private int Y; // y axis
    private int F; // direction
    
    /* Degree of each direction */
    public final int EAST = 0;
    public final int NORTH = 90;
    public final int WEST = 180;
    public final int SOUTH = 270;
    
    /* Truning degrees */
    public final int LEFT = 90;
    public final int RIGHT = -90;
    
    public final int SIZE = 5; // size of game board
    public final int INVALID = -1;
 
    public final String E = "EAST", W = "WEST", N = "NORTH", S = "SOUTH";
    
    /* Object Constructor */
    public Robot(){
        this.X = this.INVALID;
        this.Y = this.INVALID;
        this.F = this.INVALID;
    }
    
    /*
     * place the robot in a apecific grid and turn it to a specific direction
     * return true if place correctly
     * otherwise return false
     */
    public boolean place(int x, int y, String f){
        if(x < this.SIZE && x >= 0){
            this.X = x;
        }else{
            return false;
        }
        
        if (y < this.SIZE || y >= 0){
            this.Y = y;
        }else{
            return false;
        }
        
        if(f.equals(E)){
            this.F = this.EAST;
        }
        else if(f.equals(this.N)){
            this.F = this.NORTH;
        }
        else if(f.equals(this.W)){
            this.F = this.WEST;
        }
        else if(f.equals(this.S)){
            this.F = this.SOUTH;
        }else{
            //this.F = this.EAST;
            return false;
        }
        return true;
    }
    
    /*
     * move one step toward robot's current direction
     */
    public void move(){
        //if (this.X == this.INVALID || this.Y == this.INVALID || this.F == this.INVALID) return;
        
        // x+1
        if (this.F == this.EAST && this.X < this.SIZE - 1) this.X++;
        
        // y+1
        if (this.F == this.NORTH && this.Y < this.SIZE - 1) this.Y++;
        
        // x-1
        if (this.F == this.WEST && this.X > 0) this.X--;
        
        // y-1
        if (this.F == this.SOUTH && this.Y > 0) this.Y--;
    }
    
    /*
     * Robot turns left
     */
    public void turnLeft(){
        //if (this.X == this.INVALID || this.Y == this.INVALID || this.F == this.INVALID) return;
        this.F = (this.F + this.LEFT) % 360;
    }
    
    /*
     * Robot turns right
     */
    public void turnRight(){
        //if (this.X == this.INVALID || this.Y == this.INVALID || this.F == this.INVALID) return;
        if (this.F == this.EAST){
            this.F = this.SOUTH;
        }else{
            this.F = this.F + this.RIGHT;
        }
    }
    
    /*
     * Print robot's current position and direction
     */
    public void report(){
        //if (this.X == this.INVALID || this.Y == this.INVALID || this.F == this.INVALID) return;
        String F = "";
        if (this.F == this.INVALID) F = "N/A";
        if (this.F == this.EAST) F = this.E;
        if (this.F == this.NORTH) F = this.N;
        if (this.F == this.WEST) F = this.W;
        if (this.F == this.SOUTH) F = this.S;
        System.out.println("Output: " + this.X + "," + this.Y + "," + F);
    }
    
}
