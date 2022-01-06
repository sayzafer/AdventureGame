public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("--------------------Mağazaya hoşgeliniz--------------------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış yap");
            System.out.println("Seçiminiz: ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer, tekrar giriniz: ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz !");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----------Silahlar----------");
        System.out.println();
        for (Weapon w : Weapon.weapons()){
            System.out.println(w.getId() + " - " +w.getName() + " < Para:" + w.getPrice() + ", Hasar:" + w.getDamage() + " >");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.println("Bir silah seçiniz");
        int selectWeapon = input.nextInt();
        while (selectWeapon < 0 || selectWeapon > Weapon.weapons().length ){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectWeapon = input.nextInt();
        }
        if(selectWeapon != 0){
            Weapon selectedWeapon = Weapon.getWeaponObj(selectWeapon);
            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getCoin()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }else{
                    if(selectedWeapon.getId() == this.getPlayer().getInventory().getWeapon().getId())
                        System.out.println("Elinizdeki silahı satın alamazsınız!");
                    else{
                        System.out.println(selectedWeapon.getName() + "silahını satın aldınız");
                        int balance = this.getPlayer().getCoin() - selectedWeapon.getPrice();
                        this.getPlayer().setCoin(balance);
                        System.out.println("Kalan paranız:"+ this.getPlayer().getCoin());
                        System.out.println("Önceki silahınız:" + this.getPlayer().getInventory().getWeapon().getName());
                        this.getPlayer().getInventory().setWeapon(selectedWeapon);
                        System.out.println("Yeni silahınız:" + this.getPlayer().getInventory().getWeapon().getName());
                    }
                }
            }
        }

    }
    public void printArmor(){
        System.out.println("----------Zırhlar----------");
        System.out.println();
        for (Armor a:Armor.armors()){
            System.out.println(a.getId() + " - " + a.getName() +  " Zırh " + "Para:" + a.getPrice() + " Dodgelama gücü:"  + a.getBlock());
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyArmor(){
        System.out.println("Bir zırh seçiniz");
        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length ){
            System.out.println("Geçersiz değer, tekrar giriniz: ");
            selectArmorID = input.nextInt();
        }
        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObj(selectArmorID);
            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getCoin()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }else{
                    if(selectedArmor.getId() == this.getPlayer().getInventory().getArmor().getId())
                        System.out.println("Elinizdeki zırhı satın alamazsınız!");
                    else{
                        System.out.println(selectedArmor.getName() + " zırhı satın aldın!");
                        int balance = this.getPlayer().getCoin() - selectedArmor.getPrice();
                        this.getPlayer().setCoin(balance);
                        System.out.println("Kalan paranız: "+ this.getPlayer().getCoin());
                        System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                        this.getPlayer().getInventory().setArmor(selectedArmor);
                        System.out.println("Yeni zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
                    }
                }
            }
        }

    }
}
