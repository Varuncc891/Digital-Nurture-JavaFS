import os
import urllib.request
import zipfile

maven_version = "3.8.8"
maven_zip = f"apache-maven-{maven_version}-bin.zip"
url = f"https://archive.apache.org/dist/maven/maven-3/{maven_version}/binaries/{maven_zip}"
dest_dir = os.path.join(os.path.dirname(__file__), "maven")

if not os.path.exists(dest_dir):
    os.makedirs(dest_dir, exist_ok=True)
    zip_path = os.path.join(dest_dir, maven_zip)
    print(f"Downloading Maven {maven_version}...")
    try:
        urllib.request.urlretrieve(url, zip_path)
        print("Extracting Maven...")
        with zipfile.ZipFile(zip_path, 'r') as zip_ref:
            zip_ref.extractall(dest_dir)
        os.remove(zip_path)
        print("Maven setup complete.")
    except Exception as e:
        print(f"Error setting up Maven: {e}")
else:
    print("Maven already set up.")
