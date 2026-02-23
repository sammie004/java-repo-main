package list_practice.list;

abstract  class user{
   abstract String getRole();
}

class Basic extends user {

    @Override
    String getRole() {
        System.out.println("Basic access to the system");
        return null;
    }
}