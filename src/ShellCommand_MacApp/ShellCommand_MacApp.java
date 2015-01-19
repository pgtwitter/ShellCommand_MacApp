package ShellCommand_MacApp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.apple.eawt.AboutHandler;
import com.apple.eawt.AppEvent.AboutEvent;
import com.apple.eawt.AppEvent.OpenFilesEvent;
import com.apple.eawt.AppEvent.OpenURIEvent;
import com.apple.eawt.AppEvent.PreferencesEvent;
import com.apple.eawt.AppEvent.PrintFilesEvent;
import com.apple.eawt.AppEvent.QuitEvent;
import com.apple.eawt.Application;
import com.apple.eawt.OpenFilesHandler;
import com.apple.eawt.OpenURIHandler;
import com.apple.eawt.PreferencesHandler;
import com.apple.eawt.PrintFilesHandler;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.QuitResponse;

class ShellCommand_MacApp implements AboutHandler, PreferencesHandler,
		QuitHandler {
	Application theApplication;
	JFrame frame;

	public static void main(String[] args) {
		new ShellCommand_MacApp();
	}

	public ShellCommand_MacApp() {
		theApplication = Application.getApplication();
		URL icon = this.getClass().getClassLoader()
				.getResource("ShellCommand_MacApp.icns");
		try {
			theApplication.setDockIconImage(ImageIO.read(icon));
		} catch (IOException e) {
			e.printStackTrace();
		}
		theApplication.setDockIconBadge("12345678");
		theApplication.setAboutHandler(this);
		theApplication.setPreferencesHandler(this);
		theApplication.setQuitHandler(this);

		frame = new JFrame("ShellCommand MacApp");
		frame.setBounds(100, 100, 200, 160);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void handleQuitRequestWith(QuitEvent arg0, QuitResponse arg1) {
		JOptionPane.showMessageDialog(frame, "QuitEvent");
		System.exit(0);
	}

	@Override
	public void handlePreferences(PreferencesEvent arg0) {
		JOptionPane.showMessageDialog(frame, "PreferencesEvent");
	}

	@Override
	public void handleAbout(AboutEvent arg0) {
		JOptionPane.showMessageDialog(frame, "AboutEvent");
	}
}
