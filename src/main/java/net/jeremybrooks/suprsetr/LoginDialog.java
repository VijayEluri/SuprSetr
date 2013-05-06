/*
 * SuprSetr is Copyright 2010-2013 by Jeremy Brooks
 *
 * This file is part of SuprSetr.
 *
 * SuprSetr is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SuprSetr is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SuprSetr.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.jeremybrooks.suprsetr;

import net.jeremybrooks.suprsetr.workers.FlickrAuthenticatorWorker;
import org.apache.log4j.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;


/**
 * Display a dialog for Flickr authorization.
 *
 * @author jeremyb
 */
public class LoginDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = -2365590496750336438L;

	/**
	 * Logging
	 */
	private Logger logger = Logger.getLogger(LoginDialog.class);

	private ResourceBundle resourceBundle = ResourceBundle.getBundle("net.jeremybrooks.suprsetr.login");

	/**
	 * Creates new form LoginDialog.
	 *
	 * @param parent the parent frame.
	 * @param modal  display as modal.
	 */
	public LoginDialog(Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}


	/**
	 * This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		ResourceBundle bundle = this.resourceBundle;
		jScrollPane1 = new JScrollPane();
		jTextArea1 = new JTextArea();
		panel1 = new JPanel();
		panel2 = new JPanel();
		btnPreferences = new JButton();
		panel3 = new JPanel();
		btnCancel = new JButton();
		btnAuthenticate = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setTitle(bundle.getString("LoginDialog.this.title"));
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//======== jScrollPane1 ========
		{

			//---- jTextArea1 ----
			jTextArea1.setColumns(20);
			jTextArea1.setEditable(false);
			jTextArea1.setLineWrap(true);
			jTextArea1.setRows(5);
			jTextArea1.setText(bundle.getString("LoginDialog.jTextArea1.text"));
			jTextArea1.setWrapStyleWord(true);
			jScrollPane1.setViewportView(jTextArea1);
		}
		contentPane.add(jScrollPane1, BorderLayout.CENTER);

		//======== panel1 ========
		{
			panel1.setLayout(new BorderLayout());

			//======== panel2 ========
			{
				panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

				//---- btnPreferences ----
				btnPreferences.setText(bundle.getString("LoginDialog.btnPreferences.text"));
				btnPreferences.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnPreferencesActionPerformed();
					}
				});
				panel2.add(btnPreferences);
			}
			panel1.add(panel2, BorderLayout.WEST);

			//======== panel3 ========
			{
				panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

				//---- btnCancel ----
				btnCancel.setText(bundle.getString("LoginDialog.btnCancel.text"));
				btnCancel.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnCancelActionPerformed();
					}
				});
				panel3.add(btnCancel);

				//---- btnAuthenticate ----
				btnAuthenticate.setText(bundle.getString("LoginDialog.btnAuthenticate.text"));
				btnAuthenticate.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnAuthenticateActionPerformed();
					}
				});
				panel3.add(btnAuthenticate);
			}
			panel1.add(panel3, BorderLayout.CENTER);
		}
		contentPane.add(panel1, BorderLayout.SOUTH);
		setSize(419, 302);
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents


	/**
	 * Do authentication.
	 * <p/>
	 * <p>This method will block the GUI, then use the FlickrAuthenticator
	 * class to do the actual work of authentication.</p>
	 */
	private void btnAuthenticateActionPerformed() {
		BlockerPanel blocker = new BlockerPanel(this, resourceBundle.getString("LoginDialog.message.authenticating"));
		setGlassPane(blocker);
		new FlickrAuthenticatorWorker(this, blocker).execute();

	}


	/**
	 * Allow user to cancel the operation.
	 * <p/>
	 * <p>Display a warning dialog that the program will exit if they continue.</p>
	 */
	private void btnCancelActionPerformed() {
		String message = resourceBundle.getString("LoginDialog.message.cancelMessage");
		int selection = JOptionPane.showConfirmDialog(
				this,
				message,
				resourceBundle.getString("LoginDialog.message.cancelTitle"),
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE);

		if (selection == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	private void btnPreferencesActionPerformed() {
		Preferences prefs = new Preferences(null, true);
		prefs.setTabIndex(Preferences.PROXY_PANEL);
		prefs.setVisible(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JScrollPane jScrollPane1;
	private JTextArea jTextArea1;
	private JPanel panel1;
	private JPanel panel2;
	private JButton btnPreferences;
	private JPanel panel3;
	private JButton btnCancel;
	private JButton btnAuthenticate;
	// End of variables declaration//GEN-END:variables
}
