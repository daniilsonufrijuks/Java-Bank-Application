from mailersend import emails
from dotenv import load_dotenv
import os

def send():
    load_dotenv()

    mailer = emails.NewEmail(os.getenv('mlsn.186724e6fb19f297bc5fe91426fec9d3830e9e65a06a39d52056850d74ebc1a3'))

    # define an empty dict to populate with mail values
    mail_body = {}

    mail_from = {
        "name": "...",
        "email": "monolithabout@gmail.com",
    }

    recipients = [
        {
            "name": "Your Client",
            "email": "kroshthebestfriend@gmail.com",
        }
    ]

    # reply_to = {
    #     "name": "Name",
    #     "email": "reply@domain.com",
    # }

    mailer.set_mail_from(mail_from, mail_body)
    mailer.set_mail_to(recipients, mail_body)
    mailer.set_subject("Hello!", mail_body)
    mailer.set_html_content("This is the HTML content", mail_body)
    mailer.set_plaintext_content("This is the text content", mail_body)
    # mailer.set_reply_to(reply_to, mail_body)

    # using print() will also return status code and data
    mailer.send(mail_body)

def main():
    send()

main()