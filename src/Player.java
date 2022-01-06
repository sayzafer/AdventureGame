import java.util.Scanner;

public class Player {
    private int  damage;
    private int health;
    private int orijinalHealth;
    private int coin;
    private String name;
    private String warriorType;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = this.name;
        this.inventory = new Inventory();
    }

    public void selectWarrior() {
        Warriors[] warriorsList = {new Samurai(), new Archer(), new Knight()};
        System.out.println("                             Karakterler");
        System.out.println("---------------------------------------------------------------------");
        for (Warriors warriors : warriorsList) {
            System.out.println("ID :" + warriors.getId() +
                    "\tKarakter: " + warriors.getWarriorName() +
                    "\t Hasar: " + warriors.getDamage() +
                    "\t Sağlık: " + warriors.getHealth() +
                    "\t Para: " + warriors.getCoin());
        }
        System.out.println("---------------------------------------------------------------------");
        int select = input.nextInt();
        switch (select){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: " + this.getName() + " Hasar: " + this.damage + " Sağlık: " + this.health + " Para: " + this.coin);
    }


    public void initPlayer(Warriors warriors){
        this.setName(warriors.getWarriorName());
        this.setDamage(warriors.getDamage());
        this.setHealth(warriors.getHealth());
        this.setOrijinalHealth(warriors.getHealth());
        this.setCoin(warriors.getCoin());
        this.setWarriorType(warriors.getWarriorName());
    }

    public void printInfo(){
        System.out.println("Silahın:" + this.getInventory().getWeapon().getName() +
                            " Zırhın:" + this.getInventory().getArmor().getName() +
                            " Dodgelama gücün:" + this.getInventory().getArmor().getBlock() +
                            " Hasarın:" + this.getDamage() +
                            " Sağlığın:" + this.getHealth() +
                            " Paran:" + this.getCoin());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWarriorType() {
        return warriorType;
    }

    public void setWarriorType(String warriorType) {
        this.warriorType = warriorType;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getOrijinalHealth() {
        return orijinalHealth;
    }

    public void setOrijinalHealth(int orijinalHealth) {
        this.orijinalHealth = orijinalHealth;
    }
}
