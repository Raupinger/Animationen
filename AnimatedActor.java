import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AnimatedActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class AnimatedActor extends Actor
{
    private Animation currentAnimation;

    protected class Animation extends Thread{
        private GreenfootImage[] frames;
        private int[] duration;
        private boolean loop;
        private int lenght;
    public boolean abort = false;

        protected Animation(GreenfootImage[] f, int d, boolean l, int ln){
            frames = f;
            duration = new int[ln];
            for (int i = 0; i < ln; i++){
                duration[i] = d;
            }
            loop = l;
            lenght = ln;
            System.out.println("main: " + currentThread());

        }

        protected Animation(GreenfootImage[] f, int[] d, boolean l, int ln){
            frames = f;
            duration = d;
            loop = l;
            lenght = ln;
            System.out.println("main: " + currentThread());

        }

        public void run(){
            World world = getWorld();
            System.out.println(world);

            animate(world);

            while(loop == true && abort == false){
                
                animate(world);
            }
            abort = false;
            return;

        }

        private void animate(World world){
            for(int i = 0; i < lenght ; i++){
                if(abort == true){
                    return;
                }
                setImageSuper(frames[i]);
                world.repaint();
                System.out.println(frames[i]);
                try {
                    System.out.println("animation: " + currentThread());
                    sleep(duration[i]);
                } catch (Exception e) {
                    System.out.println("no waiting");
                }

            }
        }

    }

    public void animate(Animation a){
        stopAnimation();
        currentAnimation = a;
        currentAnimation.start();
    }

    public void stopAnimation(){
        if (currentAnimation == null){return;}
        currentAnimation.abort = true;
        /*
        try {currentAnimation.join();}
        catch (Exception e){ 
            System.out.println(e);
        }
        */
        currentAnimation = null;
    }

    public void setImage(GreenfootImage img){
        stopAnimation();
        super.setImage(img);
    }

    private void setImageSuper(GreenfootImage img){
        super.setImage(img);
    }
}
