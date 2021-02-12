import errno
import os
from bs4 import BeautifulSoup


def silentremove(filename):
    try:
        os.remove(filename)
    except OSError as e:  # this would be "except OSError, e:" before Python 2.6
        if e.errno != errno.ENOENT:  # errno.ENOENT = no such file or directory
            raise  # re-raise exception if a different error occurred


base_dir = "/home/eri/Downloads/brokers"

final_file = 'brokers.csv'
final_csv_path = os.path.join(base_dir, final_file)
silentremove(final_csv_path)
final_csv = open(final_csv_path, "w+")

# Get list of sub-directoryes
output = [dI for dI in os.listdir(base_dir) if os.path.isdir(os.path.join(base_dir, dI))]

for directory in output:
    output_file = directory + '.csv'
    output_path = os.path.join(base_dir, directory, output_file)
    silentremove(output_path)
    output = open(output_path, "w+")
    for filename in os.listdir(os.path.join(base_dir, directory)):
        file_path = os.path.join(base_dir, directory, filename)
        html_doc = open(file_path, "r+")
        soup = BeautifulSoup(html_doc, 'html.parser')
        p = soup.find_all('p')
        print("processing ", filename)
        for broker in p[3:-5]:
            text = broker.get_text()
            if (text.find("View More Results:") == -1 and text.find("MC #") != -1):
                if (text.find("DOT") != -1):
                    name = text[0:text.find("MC")]
                    mc = text[text.find("#") + 1:text.find("DOT")]
                    temp = text[text.find("DOT") + 5:]
                    dot = temp[:temp.find(" ")]
                    location = temp[temp.find(" "):]
                    city = location[:location.find(",")]
                    state = location[location.find(",") + 1:]
                else:
                    name = text[0:text.find("MC")]
                    temp = text[text.find("#") + 1:]
                    mc = temp[:temp.find(" ")]
                    dot = ""
                    location = temp[temp.find(" "):]
                    city = location[:location.find(",")]
                    state = location[location.find(",") + 1:]

                output.write((
                                     "\"" + name.strip() + "\",\"" + mc.strip() + "\",\"" + dot.strip() + "\",\"" + city.strip() + "\",\"" + state.strip() + "\"").encode(
                    'utf-8').strip() + '\n')
                final_csv.write((
                                        "\"" + name.strip() + "\",\"" + mc.strip() + "\",\"" + dot.strip() + "\",\"" + city.strip() + "\",\"" + state.strip() + "\"").encode(
                    'utf-8').strip() + '\n')

        html_doc.close()

    output.close()
    print("Wrote output file: ", output_file)

final_csv.close()
print("Wrote ", final_file, ". Processing exited successfully.")
