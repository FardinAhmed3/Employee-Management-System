from playwright.sync_api import Playwright, sync_playwright, expect


def run(playwright: Playwright) -> None:
    browser = playwright.chromium.launch(headless=False)
    context = browser.new_context()
    page = context.new_page()
    
    #This line should point towards the link when its hosted via 3rd party.
    #The line can be modified to use locahost, or local DNS domain with port-forwarded ports.
    #Localhost is a placeholder here.
    page.goto("Localhost")

    page.get_by_role("link", name="View Employees").click()
    page.get_by_role("link", name="Add New Employee").click()
    page.get_by_label("First Name*:").click()
    page.get_by_label("First Name*:").fill("BOT")
    page.get_by_label("Last Name:").click()
    page.get_by_label("Last Name:").fill("BOTTWO")
    page.get_by_label("Email*:").click()
    page.get_by_label("Email*:").fill("BOT@gmail.com")
    page.get_by_label("Date of Birth*:").fill("2001-01-01")
    page.get_by_label("Street Address:").click()
    page.get_by_label("Street Address:").fill("10-10 47th Street")
    page.get_by_label("Department*:").select_option("Testing Engineer")
    page.get_by_role("button", name="Add Employee").click()

    # ---------------------
    context.close()
    browser.close()


with sync_playwright() as playwright:
    run(playwright)
