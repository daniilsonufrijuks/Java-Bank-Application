import smtplib
from email.mime.text import MIMEText

def send_email(sender_email, sender_password, receiver_email, subject, body):
    # Create a MIMEText object to represent the email
    message = MIMEText(body)
    message['From'] = sender_email
    message['To'] = receiver_email
    message['Subject'] = subject

    # Connect to the SMTP server
    server = smtplib.SMTP('smtp.example.com', 25)  # Specify SMTP server and port

    # Login to the SMTP server (optional if not required)
    server.login(sender_email, sender_password)

    # Send the email
    server.sendmail(sender_email, receiver_email, message.as_string())

    # Close the connection to the SMTP server
    server.quit()

# Example usage:
sender_email = "monolithabout@gmail.com"
sender_password = "your_password"
receiver_email = "kroshthebestfriend@gmail.com"
subject = "Test Email"
body = "This is a test email sent using Python."

send_email(sender_email, sender_password, receiver_email, subject, body)
