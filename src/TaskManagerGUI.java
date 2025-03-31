import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskManagerGUI {
    private Usuario usuario;
    private JFrame frame;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public TaskManagerGUI(Usuario usuario) {
        this.usuario = usuario;
        frame = new JFrame("Gestor de Tareas - " + usuario.getNombre());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Lista de tareas
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        frame.add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Panel de botones
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1)); // Asegura que los botones se acomoden bien

        // Campo para ingresar tareas
        JPanel inputPanel = new JPanel();
        JTextField taskField = new JTextField(15);
        JButton addButton = new JButton("Agregar Tarea");
        inputPanel.add(taskField);
        inputPanel.add(addButton);

        // Panel de botones
        JPanel buttonPanel = new JPanel();
        JButton completeButton = new JButton("Completar Tarea");
        buttonPanel.add(completeButton);

        // Agregamos los paneles al principal
        panel.add(inputPanel);
        panel.add(buttonPanel);
        frame.add(panel, BorderLayout.SOUTH);

        // Acción para agregar tarea
        addButton.addActionListener(e -> {
            String tarea = taskField.getText();
            if (!tarea.isEmpty()) {
                usuario.agregarTarea(tarea);
                actualizarLista();
                taskField.setText("");
            }
        });

        // Acción para completar tarea
        completeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                usuario.completarTarea(selectedIndex);
                actualizarLista();
            } else {
                JOptionPane.showMessageDialog(frame, "Selecciona una tarea para completar.");
            }
        });

        frame.setVisible(true);
    }

    private void actualizarLista() {
        taskListModel.clear();
        for (Tarea tarea : usuario.getTareas()) {
            taskListModel.addElement(tarea.getDescripcion() + " (Completada: " + tarea.isCompletada() + ")");
        }
    }
}

