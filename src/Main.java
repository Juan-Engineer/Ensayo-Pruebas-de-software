import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String nombreUsuario = JOptionPane.showInputDialog("Ingresa tu nombre:");
        if (nombreUsuario != null && !nombreUsuario.trim().isEmpty()) {
            Usuario usuario = new Usuario(nombreUsuario);
            new TaskManagerGUI(usuario);
        } else {
            JOptionPane.showMessageDialog(null, "Debes ingresar un nombre válido.");
        }
    }
}
