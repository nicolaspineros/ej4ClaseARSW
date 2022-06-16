class Friend {
    private final String name;

    public Friend(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void bow(Friend bower){
        System.out.format("%s: %s"
                + " has bowed to me!%n",
                this.name, bower.getName());
        bower.bowBack(this);
    }

    private synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s"
                + " has bowed to me!%n",
                this.name, bower.getName());
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gatson = new Friend("Gatson");
        new Thread(new Runnable() {
            @Override
            public void run() {
                alphonse.bow(gatson);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                gatson.bow(alphonse);
            }
        }).start();
    }
}
