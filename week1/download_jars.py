import os
import urllib.request

lib_dir = os.path.join(os.path.dirname(__file__), "lib")
os.makedirs(lib_dir, exist_ok=True)

urls = {
    "junit-platform-console-standalone-1.10.2.jar": "https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.10.2/junit-platform-console-standalone-1.10.2.jar",
    "slf4j-api-2.0.12.jar": "https://repo1.maven.org/maven2/org/slf4j/slf4j-api/2.0.12/slf4j-api-2.0.12.jar",
    "slf4j-simple-2.0.12.jar": "https://repo1.maven.org/maven2/org/slf4j/slf4j-simple/2.0.12/slf4j-simple-2.0.12.jar",
    "mockito-core-5.11.0.jar": "https://repo1.maven.org/maven2/org/mockito/mockito-core/5.11.0/mockito-core-5.11.0.jar",
    "byte-buddy-1.14.12.jar": "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy/1.14.12/byte-buddy-1.14.12.jar",
    "byte-buddy-agent-1.14.12.jar": "https://repo1.maven.org/maven2/net/bytebuddy/byte-buddy-agent/1.14.12/byte-buddy-agent-1.14.12.jar",
    "objenesis-3.3.jar": "https://repo1.maven.org/maven2/org/objenesis/objenesis/3.3/objenesis-3.3.jar"
}

for filename, url in urls.items():
    dest_path = os.path.join(lib_dir, filename)
    if not os.path.exists(dest_path):
        print(f"Downloading {filename}...")
        try:
            urllib.request.urlretrieve(url, dest_path)
            print(f"Downloaded {filename}")
        except Exception as e:
            print(f"Failed to download {filename}: {e}")
    else:
        print(f"{filename} already exists.")
