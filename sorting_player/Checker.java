//
// first sort by score in descending order;
// if same score, sorted by name in ascending order
//
class Checker implements Comparator<Player> {
    public int compare(Player p1, Player p2) {
        int score = p2.score - p1.score;
        if( score == 0 ) {
            return p1.name.compareTo(p2.name);
        }
        return p2.score - p1.score;
    }
}

/*
class Player {
    String name;
    int score;
}

Player[] player = new Player[n];
Checker checker = new Checker();
Arrays.sort(player, checker);
*/
