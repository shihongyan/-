public class AccountWithoutSync {
   /*计算添加后的数量 */
    private static class Account{
        private int balance=0;
        public int getBalance(){
            return balance;
        }
        public void deposit(int amount){
            int newBalance=balance+amount;
            try{
                Thread.sleep(5);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }
}
