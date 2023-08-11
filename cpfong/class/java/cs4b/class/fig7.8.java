public class test {
        public static void main(String args[]){
                int arr[]   = {19,3,15,7,11,9,13,5,17,1};
                String st   = "Element\tValue\tHistogram";
                JTextArea o = new JTextArea();

                for (int i=0; i < arr.length; i++){
                        st += "\n" + i + "\t" + arr[i] + "\t";
                        for (int j=0; j < arr[i]; j++) {
                                st += "*";
                        }
                }

                o.setText(st);
                JOptionPane.showMessageDialog(null, o);
                System.exit(0);
        }
}

