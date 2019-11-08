package statusmgr;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import statusmgr.beans.ServerStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controller for all web/REST requests about the status of servers
 *
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 *    All start with /server
 *    /status  will give back status of server
 *    a param of 'name' specifies a requestor name to appear in response
 *
 * Examples:
 *    http://localhost:8080/server/status
 *
 *    http://localhost:8080/server/status?name=Noach
 *
 *
 *
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();


    @RequestMapping("/status")
    public ServerStatus statusRequest(@RequestParam(value="name", defaultValue="Anonymous") String name, @RequestParam(value="details", defaultValue = "1,2,3,4")List <String> values ) {
        for (int i = 0; i < values.size(); i++)
        {System.out.println("*** DEBUG INFO ***" + values.get(i) );}

        return new ServerStatus(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
