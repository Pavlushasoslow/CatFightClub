public class catfightclub
{
    static class Cat{
        private String name = null;
        int str =1, def = 1, atk =1, hp=100, age=1;
        static int catCount =1;

        public Cat (String name, int str, int def, int atk, int age){
            this.name = name;
            this.str = str;
            this.def = def;
            this.atk = atk;
            this.age = age;
            this.hp = hp+age*2;

            catCount++;
        }

        protected void finalize() throws Throwable{
            System.out.println("кот умер как объект");
            catCount--;
        }

        public void punch(Cat anotherCat){
            /* private */ int force = Math.max(0, this.atk*this.str-anotherCat.def);
            anotherCat.hp = anotherCat.hp-force;
            System.out.println(this.name + " наносит удар " + anotherCat.name + " с силой" + force + "!");
            System.out.println("Теперь у " + anotherCat.name + " осталось " + anotherCat.hp + "НР!");

        }
        // файт котов должен быть не здесь же?
        public void fight(Cat anotherCat ){
           /* private */ boolean turn = true;

            while (true)
            {
                if (turn==true) {
                    this.punch(anotherCat);
                    turn = false;
                } else {
                    anotherCat.punch(this);
                    turn = true;
                }

                if(anotherCat.hp <= 0) {
                    System.out.println(this.name + " победил!");
                    break;
                }

                if(this.hp <= 0) {
                    System.out.println(anotherCat.name + " победил!");
                    break;
                }

            }

        }

        public static void main(String[] args) {

            Cat cat1 = new Cat("Мурзик", 2, 10, 3, 6);
            Cat cat2 = new Cat("Барсик", 3, 11, 4, 4);

            cat1.fight(cat2);


        }
    }
}

