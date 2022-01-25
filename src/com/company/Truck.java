package com.company;

public class Truck implements WorkAble{
    private int id;
    private TruckTruck name;
    private String driver;
    private State state;



    public Truck(int id, TruckTruck name, String driver, State state) {
        this.id = id;
        this.name = name;
        this.driver = driver;
        this.state = state;
    }

    public Truck(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TruckTruck getName() {
        return name;
    }

    public void setName(TruckTruck name) {
        this.name = name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public static Truck makeTruck(int id, TruckTruck name, String driver, State state){
        Truck truck = new Truck();
        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.state = state;

        return truck;
    }

    @Override
    public String toString() {

        return id +"| "+ name +"           |" +driver + "                    |" + state;
    }

    @Override
    public void changeDriver() {
        if (state == State.BASE) {
            System.out.println("Теперь трак " + getName() + " ведет " + driver);
            return;

        }
        else if(state == State.ROUT || state == State.REPAIR){
            throw new RuntimeException("Грузовик в пути, нельзя сменить водителя");
        }

    }

    @Override
    public void startDriving() {
        if(state == State.BASE){
            if(!driver.isEmpty()){
                state = State.ROUT;
                System.out.println("Успешно вышли на маршрут");
            }
            else {
                throw new RuntimeException("Водителя нет. Нельзя выйти на маршрут");
            }
        }
        else if(state == State.ROUT){
            throw new RuntimeException("Грузовик уже в пути");
        }
    }

    @Override
    public void startRepair() {
        System.out.println("Уже в ремонте");
        }


    public void changeState(String newState) throws Exception {
        if(newState.equals("BASE") || newState.equals("ROUT") || newState.equals("REPAIR")){
            state = State.valueOf(newState);
        }
        else {
            throw new Exception("Неверное состоние. Введите еще раз");
        }
    }

}
