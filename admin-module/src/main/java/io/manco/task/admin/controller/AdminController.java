package io.manco.task.admin.controller;

//@RestController
public class AdminController {

   /* @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    //-------------------Retrieve All Answers--------------------------------------------------------

    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public ResponseEntity<List<Answer>> listAllAnswers() {
        List<Answer> answers = answerService.findAll();
        if(answers.isEmpty()){
            return new ResponseEntity<List<Answer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Answer>>(answers, HttpStatus.OK);
    }


    //-------------------Retrieve Single Answer--------------------------------------------------------

    @RequestMapping(value = "/answer/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Answer> getAnswer(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Answer answer = answerService.find(id);
        if (answer == null) {
            System.out.println("Answer with id " + id + " not found");
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Answer>(answer, HttpStatus.OK);
    }*/



/*    //-------------------Create a Answer--------------------------------------------------------

    @RequestMapping(value = "/answer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createAnswer(@RequestBody Answer answer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Answer " + answer.getDescription());

        if (answerService.isAnswerExist(answer)) {
            System.out.println("A Answer with name " + answer.getDescription() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        answerService.save(answer);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(answer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Answer --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        System.out.println("Updating User " + id);

        User currentUser = userService.findById(id);

        if (currentUser==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setName(user.getName());
        currentUser.setAge(user.getAge());
        currentUser.setSalary(user.getSalary());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete a Answer --------------------------------------------------------

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);

        User user = userService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserById(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Users --------------------------------------------------------

    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteAllUsers() {
        System.out.println("Deleting All Users");

        userService.deleteAllUsers();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }*/
}
