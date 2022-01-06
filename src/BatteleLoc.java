import java.util.Random;

public class BatteleLoc extends Locations{
    private Monster monster;
    private String award;
    private int maxMonster;

    public BatteleLoc(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Şuan buradasınız: " + this.getName());
        System.out.println("Dikkatli ol burada " + monsterNumber + " tane " + this.getMonster().getName() + " yaşıyor!");
        System.out.println("<S>avaş veya <K>aç");
        String selectEvent = input.nextLine();
        selectEvent = selectEvent.toUpperCase();
        if (selectEvent.equals("S")){
            //Battle
            if(combat(monsterNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz");
                return true;
            }
        }
        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println("Öldünüz!");
            return false;
        }
        return true;
    }

    public boolean combat(int monsterNumber){
        for(int i = 1; i <= monsterNumber; i++){
            this.getMonster().setHealth(this.getMonster().getOrjinalHealth());
            playerStats();
            monsterStats(i);
            while (this.getPlayer().getHealth() > 0 && this.getMonster().getHealth() > 0 ){
                System.out.println("<V>ur ya da <K>aç");
                String selectCombat = input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    System.out.println("Vurdunuz");
                    this.getMonster().setHealth(this.monster.getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if(this.getMonster().getHealth() > 0 ){
                        System.out.println("Canavar size vurdu");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if(monsterDamage < 0 ){
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealth(this.getPlayer().getHealth() - monsterDamage);
                        afterHit();
                    }
                } else
                    return false;
            }
            if (this.getMonster().getHealth() < this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getMonster().getAward() + " para kazandınız");
                this.getPlayer().setCoin(this.getPlayer().getCoin() + this.getMonster().getAward());
                System.out.println("Güncel paranız: " + this.getPlayer().getCoin());
                System.out.println();
            }
        }
        return false;
    }

    public void playerStats(){
        System.out.println("         Oyuncu değerleri");
        System.out.println("-----------------------------------");
        System.out.println("Sağlık: " + this.getPlayer().getHealth());
        System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh: "+ this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar: " + this.getPlayer().getTotalDamage());
        System.out.println("Para: " + this.getPlayer().getCoin());
        System.out.println();
    }

    public void monsterStats(int i){
        System.out.println(i + ". " + this.getMonster().getName() + " değerleri");
        System.out.println("Sağlık: " + this.getMonster().getHealth());
        System.out.println("Hasar: " + this.getMonster().getDamage());
        System.out.println("Ödülü: " + this.getMonster().getAward());
        System.out.println();
    }

    public void afterHit(){
        System.out.println("Canınız: " + this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName() + " canı: " + this.getMonster().getHealth());
    }

    public int randomMonsterNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxMonster()) + 1;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
