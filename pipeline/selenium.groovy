import hudson.model.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

def setKeyValue(key, value, file_path) {
    // read file, get string object
    file_content_old = readFile file_path
    println file_content_old
    lines = file_content_old.tokenize("\n")
    new_lines = []
    lines.each { line ->
        if(line.trim().startsWith(key)) {
            line = key + "=" + value
            new_lines.add(line)
        }else {
            new_lines.add(line)
        }
    }
    // write into file
    file_content_new = ""
    new_lines.each{line ->
        file_content_new += line + "\n"
    }

    writeFile file: file_path, text: file_content_new, encoding: "UTF-8"
}

def get_html_report_filename(report_store_path) {
    get_html_file_command = "cd ${report_store_path}&dir /b /s *.html"
    out = bat(script:get_html_file_command,returnStdout: true).trim()
    out = out.tokenize("\n")[1] // get the second line string
    println out
    html_report_filename = out.split("test-output")[1].replace("\\", "")
    println html_report_filename
    return html_report_filename
}

return this;